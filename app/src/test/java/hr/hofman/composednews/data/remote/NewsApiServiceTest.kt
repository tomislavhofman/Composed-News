package hr.hofman.composednews.data.remote

import com.squareup.moshi.Moshi
import hr.hofman.composednews.DaggerTestComponent
import junit.framework.TestCase
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

const val jsonResponseFileName = "news_api_response_test.json"

class NewsApiServiceTest {

    @Inject lateinit var moshi: Moshi
    @Inject lateinit var service: NewsApiService
    @Inject lateinit var mockWebServer: MockWebServer

    private val newsApiFakeResponse by lazy {
        moshi.adapter(NewsApiResponse::class.java)
            .fromJson(
                Utils.getJson(
                    jsonResponseFileName
                )
            )
    }

    @Before
    fun setup() {
        DaggerTestComponent.builder()
            .build()
            .inject(this)
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun testGetHeadlines() {
        mockWebServer.enqueue(
            MockResponse()
                .setBody(Utils.getJson(jsonResponseFileName))
                .setResponseCode(200)
        )

        val testObserver = service.getTopHeadlines().test()

        TestCase.assertEquals(testObserver.values()[0].articles, newsApiFakeResponse!!.articles)
    }
}