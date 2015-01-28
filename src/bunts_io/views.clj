(ns bunts-io.views
  (:use [hiccup core page]))

(defn home-page []
  (html
    [:head 
      [:title "Bunts.io"]]
    [:body
      [:canvas {:id "gol"}]
      [:div {:id "content"}
        [:h1 "Bunts.io"]
        [:ul {:id "menu"}
          [:li [:a {:href "/aaa"} "Blog"]]
          [:li [:a {:href "/aaa"} "Projects"]]
          [:li [:a {:href "/aaa"} "Contact"]]]]]
     (include-css "/css/gol.css")
     (include-js "/js/gol.js")))
