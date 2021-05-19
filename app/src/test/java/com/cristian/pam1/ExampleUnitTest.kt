package com.cristian.pam1

import com.cristian.pam1.data.api.ApiService
import com.cristian.pam1.data.model.ApiResponse
import com.cristian.pam1.data.model.PosterImage
import com.cristian.pam1.data.repository.ContentRepository
import com.cristian.pam1.ui.feed.models.FeedItem
import com.cristian.pam1.ui.viewmodel.ContentFragmentViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.net.URL

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@ExperimentalCoroutinesApi
class ExampleUnitTest {
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun onSuccessfulRequest_shouldUpdateUI() = runBlockingTest {
        // Init mock objects
        val feedInputMock = mock<FeedItem>()
        val apiServiceMock = mock<ApiService>()
        val contRepository = mock<ContentRepository>()
        val viewModel = mock<ContentFragmentViewModel>()

        // Init stub objects
        val posterImage = mock<PosterImage>()
        whenever(posterImage.small).thenReturn(URL("http://test.com"))

        val attr = mock<ApiResponse.Attributes>()
        whenever(attr.canonicalTitle).thenReturn("ZACEM VI ZDESI UCITELI")
        whenever(attr.description).thenReturn("BEST DESCRIPTION")
        whenever(attr.ageRatingGuide).thenReturn("for big boyz")
        whenever(attr.averageRating).thenReturn("best")
        whenever(attr.status).thenReturn("ongoing")
        whenever(attr.posterImage).thenReturn(posterImage)

        val links = mock<ApiResponse.Links>()
        whenever(links.first).thenReturn(URL("http://test.com"))
        whenever(links.next).thenReturn(URL("http://test.com"))
        whenever(links.last).thenReturn(URL("http://test.com"))

        val cont = mock<ApiResponse.ContentObj>()
        whenever(cont.attributes).thenReturn(attr)
        whenever(cont.id).thenReturn("fiorst")
        whenever(cont.type).thenReturn("best type")


        val tocinaResponse = mock<ApiResponse>()
        whenever(tocinaResponse.data).thenReturn(arrayListOf(cont))

        whenever(apiServiceMock.searchContent("ZACEM VI ZDESI UCITELI")).thenReturn(tocinaResponse)

        // Init expected result
        val expectedDataSet = arrayOf(
            FeedItem(cont.attributes.posterImage.small.toString(),
                cont.attributes.canonicalTitle,
                cont.attributes.description,
                cont.attributes.averageRating,
                cont.attributes.ageRatingGuide,
                cont.attributes.status
            )
        )

        // Perform tested action
        viewModel.getContent()

        // Verify required methods was called with required parameters
        verify(apiServiceMock).searchContent("ZACEM VI ZDESI UCITELI")
        verify(contRepository).searchContent("ZACEM VI ZDESI UCITELI")
        verify(viewModel).getContent()
    }

    @Test
    fun onFetchErrorRequest_shouldPresentErrorAlertDialog() = runBlockingTest {
        // Init mock objects
        val feedInputMock = mock<FeedItem>()
        val apiServiceMock = mock<ApiService>()
        val contRepository = mock<ContentRepository>()
        val viewModel = mock<ContentFragmentViewModel>()

        val errorMessage = "Network Error"
        val error = Error(errorMessage)
        whenever(apiServiceMock.searchContent("SOME GOOD CONTENT")).thenThrow(error)

        // Perform tested action
        viewModel.getContent()

        // Verify required methods was called with required parameters
        verify(apiServiceMock).searchContent("VERY GOOD CONTENT")
        verify(contRepository).searchContent("ZACEM VI ZDESI UCITELI")
        verify(viewModel).getContent()
    }
}