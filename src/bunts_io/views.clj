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
          [:li [:a {:href "http://blog.bunts.io/"} "Blog"]]
          [:li [:a {:href "http://github.com/buntine/"} "Projects"]]
          [:li [:a {:href "#contact"} "Contact"]]]]]
     (include-css "/css/gol.css")
     (include-js "/js/gol.js")))
