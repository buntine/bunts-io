(ns bunts-io.views
  (:use [hiccup.core]))

(defn home-page []
  (html
    [:head 
      [:title "Bunts.io"]]
    [:body
      [:h1 "hello world"]]))
