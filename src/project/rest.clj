(ns project.rest
  (:require [compojure.core :refer [defroutes GET]]
            [org.httpkit.server :as httpkit]
            [spiral.adapters.http-kit :as http-kit-adapter]
            [spiral.core :as spiral]
            [ring.middleware.reload :as reload]))

(defroutes app-routes
  (GET "/" []
    "Fascinating!"))

(def app
  (-> #'app-routes
      (reload/wrap-reload)))

(def spiral-app
  (spiral/sync->async-adapter app
                              {:parallelism 10
                               :buffer-size 5}))

(defn run-server []
  (httpkit/run-server (http-kit-adapter/to-httpkit spiral-app)
                                                   {:port 8080}))
