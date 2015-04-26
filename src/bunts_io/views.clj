(ns bunts-io.views
  (:use [hiccup core page]))

(defn home-page []
  (html
    [:head 
      [:title "Bunts.io"]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1, maximum-scale=1"}]]
    [:body
      [:canvas {:id "gol"}]
      [:div {:id "content"}
        [:div {:id "nav"}
          [:h1 "Bunts.io"]
          [:ul {:id "menu"}
            [:li [:a {:href "http://codrspace.com/buntine/"} "BLOG"]]
            [:li [:a {:href "http://github.com/buntine/"} "PROJECTS"]]
            [:li [:a {:href "#" :id "contact"} "CONTACT"]
                 [:span {:id "swagmail"} "&#105;&#110;&#102;&#111;&#064;&#098;&#117;&#110;&#116;&#115;&#046;&#105;&#111;"]]]]]]
     (include-css "/css/gol.css")
     (include-css "/css/main.css")
     (include-js "/js/functional.min.js")
     (include-js "/js/shifty.min.js")
     (include-js "/js/main.js")
     (include-js "/js/gol.js")))
