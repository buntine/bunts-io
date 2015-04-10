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
          [:li [:a {:href "http://codrspace.com/buntine/"} "Blog"]]
          [:li [:a {:href "http://github.com/buntine/"} "Projects"]]
          [:li [:a {:href "#" :id "contact"} "Contact"]
               [:span {:id "swagmail"} "&#105;&#110;&#102;&#111;&#064;&#098;&#117;&#110;&#116;&#115;&#046;&#105;&#111;"]]]]]
     (include-css "/css/gol.css")
     (include-css "/css/main.css")
     (include-js "/js/functional.min.js")
     (include-js "/js/shifty.min.js")
     (include-js "/js/main.js")
     (include-js "/js/gol.js")))
