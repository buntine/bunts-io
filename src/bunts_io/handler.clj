(ns bunts-io.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [bunts-io.views :as views]
            [selmer.parser :as sp]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] (views/home-page))
  (GET "/experiments/:exp_name" [exp_name]
    (sp/render-file (str "public/raw/" exp_name) {}))

  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
