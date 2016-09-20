(ns bunts-io.views
  (:use [hiccup core page]))

(defn home-page []
  (html5 {:lang "en"}
    [:head 
      [:title "Andrew Buntine - Bunts.io"]
      [:meta {:name "description" :content "Andrew Buntine - Conjurer of computational spells and trickery."}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1, maximum-scale=1"}]]
    [:body
      [:canvas {:id "gol"}]
      [:div {:id "content"}
        [:div {:id "nav"}
          [:h1 "Andrew Buntine, Melbourne Australia. Bunts.io"]
          [:ul {:id "menu"}
            [:li [:a {:href "http://codrspace.com/buntine/"} "BLOG"]]
            [:li [:a {:href "http://github.com/buntine/"} "PROJECTS"]]
            [:li [:a {:href "#" :id "contact"} "CONTACT"]
                 [:span {:id "swagmail"} "&#105;&#110;&#102;&#111;&#064;&#098;&#117;&#110;&#116;&#115;&#046;&#105;&#111;"]]]]]]
     (include-css "/css/app.css")
     (include-js "/js/app.js")))
