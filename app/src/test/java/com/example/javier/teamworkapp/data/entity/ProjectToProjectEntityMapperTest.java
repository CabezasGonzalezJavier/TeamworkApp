package com.example.javier.teamworkapp.data.entity;

import com.example.javier.teamworkapp.data.entity.data.FakeRemoteAPI;
import com.example.javier.teamworkapp.data.repository.datasource.mapper.ProjectDomainToProjectEntityMapper;
import com.example.javier.teamworkapp.domain.model.ProjectDomain;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.example.javier.teamworkapp.data.entity.data.FakeRemoteAPI.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProjectToProjectEntityMapperTest { public static final String FAKE_PROJECT_NAME = "name";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    public ProjectDomainToProjectEntityMapper mapper;

    @Before
    public void setUp() {
        mapper = new ProjectDomainToProjectEntityMapper();
    }

    @Test
    public void givenTransformCollectionProjectEntityCorrectly() throws Exception {
        Project project = FakeRemoteAPI.getProject();
        ProjectDomain projectDomain = mapper.reverseMap(project);
        assertThat(projectDomain, is(instanceOf(ProjectDomain.class)));
        assertThat(projectDomain.getName(), is(FAKE_PROJECT_NAME));
        assertThat(projectDomain.getDescription(), is(FAKE_PROJECT_DESCRIPTION));
        assertThat(projectDomain.getCreate(), is("12.06.2018 19:30:44"));
        assertThat(projectDomain.getLastChange(), is("12.06.2018 19:30:44"));
        assertThat(projectDomain.getEnd(), is("22.08.1970 14:45:15"));
        assertThat(projectDomain.getLogo(), is(FAKE_PROJECT_LOGO));
        assertThat(projectDomain.getStart(), is("22.08.1970 14:45:15"));
    }

    @Test
    public void givenExpectedExceptionTransformUserEntityCollectionNotValidResponse() {
        expectedException.expect(UnsupportedOperationException.class);
        mapper.map(new ProjectDomain());
    }
}
