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
package org.dashbuilder.client.gallery;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.dashbuilder.client.resources.i18n.AppConstants;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.client.mvp.UberView;
import org.uberfire.mvp.PlaceRequest;

@WorkbenchScreen(identifier = "GalleryTreeScreen")
@Dependent
public class GalleryTreePresenter {

    public interface GalleryTreeView extends UberView<GalleryTreePresenter> {

    }

    @Inject
    GalleryTreeView view;

    @Inject
    PlaceManager placeManager;

    @WorkbenchPartTitle
    public String getTitle() {
        return AppConstants.INSTANCE.gallerytree_title();
    }

    @WorkbenchPartView
    public UberView<GalleryTreePresenter> getView() {
        return view;
    }

    public void navigateToNode(GalleryTreeNode node) {
        if (node instanceof GalleryPlaceRequest) {
            PlaceRequest placeRequest = ((GalleryPlaceRequest) node).getPlaceRequest();
            placeManager.goTo(placeRequest);
        }
    }
}
