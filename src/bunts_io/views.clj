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
          [:li [:a {:href "#" :id "contact"} "Contact"]
               [:span {:id "email"} "info@bunts.io"]]]]]
     (include-css "/css/gol.css")
     (include-css "/css/main.css")
     (include-js "/js/functional.min.js")
     (include-js "/js/shifty.min.js")
     (include-js "/js/main.js")
     (include-js "/js/gol.js")))
