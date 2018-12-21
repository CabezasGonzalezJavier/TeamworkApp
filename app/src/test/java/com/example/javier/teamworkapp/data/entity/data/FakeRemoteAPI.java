package com.example.javier.teamworkapp.data.entity.data;

import com.example.javier.teamworkapp.data.entity.Project;
import com.example.javier.teamworkapp.data.entity.ProjectEntity;

import java.util.ArrayList;
import java.util.List;

public class FakeRemoteAPI {

    public static final String FAKE_PROJECT_NAME = "name";
    public static final String FAKE_PROJECT_DESCRIPTION = "description";
    public static final String FAKE_PROJECT_CREATE = "2018-06-12T17:30:44Z";
    public static final String FAKE_PROJECT_START = "20140405";
    public static final String FAKE_PROJECT_END = "20181016";
    public static final String FAKE_PROJECT_LAST_CHANGE = "2018-06-12T17:30:44Z";
    public static final String FAKE_PROJECT_STATUS = "STATUS";
    public static final String FAKE_PROJECT_LOGO = "logo";
    private static final String JSON_RESPONSE = "{\"STATUS\":\"OK\",\"projects\":[{\"replyByEmailEnabled\":true,\"starred\":false,\"show-announcement\":false,\"harvest-timers-enabled\":false,\"status\":\"active\",\"subStatus\":\"late\",\"defaultPrivacy\":\"open\",\"integrations\":{\"xero\":{\"countrycode\":\"\",\"enabled\":false,\"connected\":\"NO\",\"organisation\":\"\",\"basecurrency\":\"\"},\"sharepoint\":{\"enabled\":false,\"folder\":\"root\",\"account\":\"\",\"foldername\":\"root\"},\"microsoftConnectors\":{\"enabled\":false},\"onedrivebusiness\":{\"enabled\":false,\"folder\":\"root\",\"account\":\"\",\"foldername\":\"root\"}},\"created-on\":\"2018-06-12T17:30:44Z\",\"category\":{\"name\":\"\",\"id\":\"\",\"color\":\"\"},\"filesAutoNewVersion\":false,\"overview-start-page\":\"default\",\"tags\":[],\"logo\":\"https:\\/\\/s3.amazonaws.com\\/TWFiles\\/349705\\/projectLogo\\/tf_929A76DB-AA0C-B885-B716E9094F4683F5.animated-brazil-flag-brazilian-national-banner_h2nf-ru_F0000.png\",\"startDate\":\"20140405\",\"id\":\"457090\",\"last-changed-on\":\"2018-12-17T10:39:55Z\",\"endDate\":\"20181209\",\"defaults\":{\"privacy\":\"\"},\"company\":{\"name\":\"Cat\",\"is-owner\":\"1\",\"id\":\"113332\"},\"tasks-start-page\":\"default\",\"name\":\"Brazil\",\"privacyEnabled\":false,\"description\":\"This is going to be a normal description of an amazing country :D\",\"announcement\":\"\",\"isProjectAdmin\":true,\"start-page\":\"projectoverview\",\"notifyeveryone\":false,\"boardData\":{},\"announcementHTML\":\"\"},{\"replyByEmailEnabled\":true,\"starred\":true,\"show-announcement\":false,\"harvest-timers-enabled\":false,\"status\":\"active\",\"subStatus\":\"late\",\"defaultPrivacy\":\"open\",\"integrations\":{\"xero\":{\"countrycode\":\"\",\"enabled\":false,\"connected\":\"NO\",\"organisation\":\"\",\"basecurrency\":\"\"},\"sharepoint\":{\"enabled\":false,\"folder\":\"root\",\"account\":\"\",\"foldername\":\"root\"},\"microsoftConnectors\":{\"enabled\":false},\"onedrivebusiness\":{\"enabled\":false,\"folder\":\"root\",\"account\":\"\",\"foldername\":\"root\"}},\"created-on\":\"2018-07-15T13:51:56Z\",\"category\":{\"name\":\"mobile\",\"id\":\"26882\",\"color\":\"\"},\"filesAutoNewVersion\":false,\"overview-start-page\":\"default\",\"tags\":[],\"logo\":\"https:\\/\\/s3.amazonaws.com\\/TWFiles\\/349705\\/projectLogo\\/tf_2E2AD316-DAF2-C47C-BA4D4BCE9184E395.Fg204.jpg\",\"startDate\":\"20180715\",\"id\":\"462923\",\"last-changed-on\":\"2018-11-09T23:37:16Z\",\"endDate\":\"20181016\",\"defaults\":{\"privacy\":\"\"},\"company\":{\"name\":\"Cat\",\"is-owner\":\"1\",\"id\":\"113332\"},\"tasks-start-page\":\"default\",\"name\":\"Time Machine R&D\",\"privacyEnabled\":false,\"description\":\"The Future Gadget 204, 2nd Edition Ver. 2.31 is a full-fledged time machine, albeit it is still incomplete and, as a result, is only capable of allowing the user to travel backwards in time, as opposed to the time machine developed by SERN, which enables time travel in both directions.\",\"announcement\":\"\",\"isProjectAdmin\":true,\"start-page\":\"projectoverview\",\"notifyeveryone\":false,\"boardData\":{},\"announcementHTML\":\"\"}]}";

    public static String getJsonResponseProjectEntityCollection() {
        return JSON_RESPONSE;
    }


    public static ProjectEntity getProject() {

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setSTATUS(FAKE_PROJECT_STATUS);
        List<Project> projectList = new ArrayList<>();
        Project project = new Project();
        project.setName(FAKE_PROJECT_NAME);
        project.setDescription(FAKE_PROJECT_DESCRIPTION);
        project.setCreatedOn(FAKE_PROJECT_CREATE);
        project.setStartDate(FAKE_PROJECT_START);
        project.setEndDate(FAKE_PROJECT_END);
        project.setLastChangedOn(FAKE_PROJECT_LAST_CHANGE);
        project.setLogo(FAKE_PROJECT_LOGO);
        projectList.add(project);
        projectEntity.setProjects(projectList);


        return projectEntity;
    }
}
