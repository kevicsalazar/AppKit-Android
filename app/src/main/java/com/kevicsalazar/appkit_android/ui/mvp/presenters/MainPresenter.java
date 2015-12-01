package com.kevicsalazar.appkit_android.ui.mvp.presenters;

import com.kevicsalazar.appkit_android.cloud.ws.WebServiceProject;
import com.kevicsalazar.appkit_android.ui.mvp.model.Project;
import com.kevicsalazar.appkit_java.BasePresenter;
import com.kevicsalazar.appkit_java.enums.LoadStatus;
import com.kevicsalazar.appkit_java.interfaces.LoadCallback;

import java.util.List;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class MainPresenter implements BasePresenter {

    public View view;
    private WebServiceProject wsp;

    public MainPresenter(WebServiceProject wsp) {
        this.wsp = wsp;
    }

    public void getListProjects() {
        wsp.getListProjects(new LoadCallback<List<Project>>() {
            @Override
            public void onLoadStatus(LoadStatus status) {

            }

            @Override
            public void onLoadSuccess(List<Project> projectList) {
                if (view != null) {
                    view.addProjectListToAdapter(projectList);
                }
            }

            @Override
            public void onLoadFailure(int resId) {

            }
        });
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public interface View {

        void addProjectListToAdapter(List<Project> projectList);

    }

}
