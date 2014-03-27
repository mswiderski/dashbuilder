/**
 * Copyright (C) 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dashbuilder.kpi.client;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.google.gwt.user.client.ui.IsWidget;
import org.dashbuilder.client.kpi.KPI;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.lifecycle.OnStartup;
import org.uberfire.mvp.PlaceRequest;

@WorkbenchScreen(identifier = "KPIPresenter")
@Dependent
public class KPIPresenter {

    public interface View extends IsWidget {

        void init(KPI kpi);
    }

    /** The KPI to display */
    private KPI kpi;

    /** The KPI locator */
    @Inject private KPILocator kpiLocator;

    /** The KPI widget */
    @Inject private View view;

    /*@OnStartup*/
    @PostConstruct
    public void onStartup(/* final PlaceRequest placeRequest */) {
        //String kpiUid = placeRequest.getParameter( "kpi", "sample1" );
        /*this.kpi = kpiLocator.getKPI(kpiUid);*/
        this.kpi = kpiLocator.getKPI("sample1");
        view.init(kpi);
    }

    @WorkbenchPartTitle
    public String getTitle() {
        return "KPI";
    }

    @WorkbenchPartView
    public IsWidget getView() {
        return view;
    }
}