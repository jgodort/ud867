/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.jgodort.builtitbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.jgodort.JokeCatalog;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builtitbigger.jgodort.com",
                ownerName = "backend.builtitbigger.jgodort.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "getJokeFromBackend")
    public JokeWrapper getJokeFromBackend() {

        JokeCatalog jokeTeller = new JokeCatalog();

        JokeWrapper response = new JokeWrapper();
        response.setJoke(jokeTeller.tellMeAJoke());

        return response;
    }

}
