package com.kevicsalazar.appkit_android.cloud.ws;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.kevicsalazar.appkit_android.R;
import com.kevicsalazar.appkit_android.ui.mvp.model.Project;
import com.kevicsalazar.appkit_java.enums.LoadStatus;
import com.kevicsalazar.appkit_java.interfaces.LoadCallback;
import com.kevicsalazar.appkit_java.utils.AppDateUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class WebServiceProject {

    private ProjectService service;

    public WebServiceProject(ProjectService service) {
        this.service = service;
    }

    public void getListProjects(final LoadCallback<List<Project>> cb) {
        cb.onLoadStatus(LoadStatus.LOADING);
        service.listProjects().enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Response<JsonArray> response, Retrofit retrofit) {
                cb.onLoadStatus(LoadStatus.LOADED);
                if (response.isSuccess()) {
                    List<Project> projectList = new ArrayList<>();
                    JsonArray jsonArray = response.body();
                    for (JsonElement jsonElement : jsonArray) {
                        JsonObject jsonObject = jsonElement.getAsJsonObject();
                        Project project = new Project();
                        project.setId(jsonObject.get("objectId").getAsString());
                        project.setTitle(jsonObject.get("title").getAsString());
                        project.setDescription(jsonObject.get("description").getAsString());
                        project.setImageUrl(jsonObject.get("image").getAsJsonObject().get("url").getAsString());
                        project.setLink(jsonObject.get("link").getAsString());
                        project.setCreatedAt(AppDateUtils.getDateFromString(AppDateUtils.SDF05, jsonObject.get("createdAt").getAsString()));
                        project.setUpdatedAt(AppDateUtils.getDateFromString(AppDateUtils.SDF05, jsonObject.get("updatedAt").getAsString()));
                        projectList.add(project);
                    }
                    cb.onLoadSuccess(projectList);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                cb.onLoadStatus(LoadStatus.LOADED);
                cb.onLoadFailure(R.string.app_name);
            }
        });

    }

    public interface ProjectService {

        @GET("/service/listProjects")
        Call<JsonArray> listProjects();

    }

}
