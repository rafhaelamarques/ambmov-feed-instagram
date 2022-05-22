package br.com.cotemig.instagram.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import br.com.cotemig.instagram.R
import br.com.cotemig.instagram.models.Post
import br.com.cotemig.instagram.services.RetrofitInitializer
import br.com.cotemig.instagram.ui.adapters.FeedAdapter
import retrofit2.Call
import retrofit2.Response

class FeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        getPosts()
    }

    private fun getPosts() {
        var s = RetrofitInitializer().getPostService()
        var call = s.getFeed()

        call.enqueue(object : retrofit2.Callback<List<Post>> {
            override fun onResponse(
                call: Call<List<Post>>,
                response: Response<List<Post>>
            ) {
                response.body()?.let{
                    showFeed(it)
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun showFeed(list: List<Post>){
        var feed = findViewById<ListView>(R.id.feedList)
        feed.adapter = FeedAdapter(this, list)
    }
}