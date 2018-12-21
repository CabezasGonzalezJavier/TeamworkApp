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
        ProjectEntity project = FakeRemoteAPI.getProject();
        ProjectDomain projectDomain = mapper.reverseMap(project);
        assertThat(projectDomain, is(instanceOf(ProjectDomain.class)));
        assertThat(projectDomain.getStatus(), is(FAKE_PROJECT_STATUS));
        assertThat(projectDomain.getSortProjectList().get(0).getName(), is(FAKE_PROJECT_NAME));
        assertThat(projectDomain.getSortProjectList().get(0).getDescription(), is(FAKE_PROJECT_DESCRIPTION));
        assertThat(projectDomain.getSortProjectList().get(0).getCreate(), is(FAKE_PROJECT_CREATE));
        assertThat(projectDomain.getSortProjectList().get(0).getEnd(), is(FAKE_PROJECT_END));
        assertThat(projectDomain.getSortProjectList().get(0).getLogo(), is(FAKE_PROJECT_LOGO));
        assertThat(projectDomain.getSortProjectList().get(0).getStart(), is(FAKE_PROJECT_START));
    }

    @Test
    public void givenExpectedExceptionTransformUserEntityCollectionNotValidResponse() {
        expectedException.expect(UnsupportedOperationException.class);
        mapper.map(new ProjectDomain());
    }
}
