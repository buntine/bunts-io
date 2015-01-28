(ns bunts-io.views
  (:use [hiccup core page]))

(defn home-page []
  (html
    [:head 
      [:title "Bunts.io"]]
    [:body
      [:canvas {:id "gol"}]]
     (include-css "/css/gol.css")
     (include-js "/js/gol.js")))
