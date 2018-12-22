package com.example.javier.teamworkapp.data.remote;

import android.util.Base64;
import com.example.javier.teamworkapp.data.entity.ProjectEntity;
import com.example.javier.teamworkapp.data.entity.data.FakeRemoteAPI;
import com.google.gson.Gson;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

import static com.example.javier.teamworkapp.Constants.API_KEY;
import static com.example.javier.teamworkapp.Constants.URL_BASE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class RemoteApiTest {

    ProjectEntity projectEntity;
    MockWebServer mockWebServer;

    @Before
    public void setUp() {
        projectEntity =  FakeRemoteAPI.getProject();
        mockWebServer = new MockWebServer();
    }

    @BeforeClass
    public static void setUpRxSchedulers() {
        Scheduler immediate = new Scheduler() {
            @Override
            public Disposable scheduleDirect(@NonNull Runnable run, long delay, @NonNull TimeUnit unit) {
                // this prevents StackOverflowErrors when scheduling with a delay
                return super.scheduleDirect(run, 0, unit);
            }

            @Override
            public Worker createWorker() {
                return new ExecutorScheduler.ExecutorWorker(Runnable::run);
            }
        };

        RxJavaPlugins.setInitIoSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitComputationSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitNewThreadSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitSingleSchedulerHandler(scheduler -> immediate);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> immediate);
    }

    @Test
    public void severCallWithError() {
        //Given
        mockWebServer.enqueue(new MockResponse().setBody(new Gson().toJson(projectEntity)));
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mockWebServer.url(URL_BASE))
                .build();
        RemoteApi remoteDataSource = new RemoteImpl(retrofit);

        TestObserver<ProjectEntity> testObserver = remoteDataSource.getProjectEntity(API_KEY).test();

        testObserver.hasSubscription();
        assertThat(testObserver.errors(), is(notNullValue()));
    }


}
