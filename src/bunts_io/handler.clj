(ns bunts-io.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [bunts-io.views :as views]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] (views/home-page))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
