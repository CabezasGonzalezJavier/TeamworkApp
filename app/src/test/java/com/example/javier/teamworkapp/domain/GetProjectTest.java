package com.example.javier.teamworkapp.domain;

import com.example.javier.teamworkapp.data.repository.Repository;
import com.example.javier.teamworkapp.domain.usecases.GetProjects;
import io.reactivex.schedulers.Schedulers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class GetProjectTest {

    @Mock
    private Repository repository;

    GetProjects getProjects;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        getProjects = givenAGetProjectUseCase();
    }

    @Test
    public void givenAConcreteUseCaseOfGetProject() {
        assertThat(getProjects, is(instanceOf(GetProjects.class)));
    }

    @Test
    public void getGetProjectObservableFromRepository() {
        getProjects.createObservableUseCase();
        verify(repository).getProject();
        verifyNoMoreInteractions(repository);
    }

    public GetProjects givenAGetProjectUseCase() {
        return new GetProjects(Schedulers.trampoline(), Schedulers.trampoline(), repository);
    }
}
