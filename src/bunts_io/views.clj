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

(defn resume []
  (html5 {:lang "en"}
    [:head 
      [:title "Andrew Buntine - Bunts.io"]
      [:meta {:name "description" :content "Andrew Buntine - Conjurer of computational spells and trickery."}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1, maximum-scale=1"}]]
    [:body {:id "resume"}
      [:header
        [:h1 "Andrew Buntine"]
        [:h3 "Software Developer & Mentor"]
        [:span "Melbourne, Australia"]
        [:div {:id "contact"}
          [:div "info@bunts.io"]
          [:div "0423 638 309"]
          [:div "http://bunts.io"]]]
      [:section {:id "summary"}
        [:h2 "Summary"]
        [:div {:class "indent"}
          [:p "This is me."]]]
      [:section {:id "experience"}
        [:h2 "Experience"]
        [:div {:class "indent"}
          [:ul
            [:li [:strong "Job Title"]]
            [:li "Company name, Location"]
            [:li "Duration - Duration"]
            [:li {:class "details"} "Details."]]
          [:ul
            [:li [:strong "Job Title"]]
            [:li "Company name, Location"]
            [:li "Duration - Duration"]
            [:li {:class "details"} "Details."]]]]
      [:section {:id "education"}
        [:h2 "Education"]
        [:div {:class "indent"}
          [:ul
            [:li [:strong "Qualification"]]
            [:li "Institution, Location"]
            [:li "Duration - Duration"]]
          [:ul
            [:li [:strong "Qualification"]]
            [:li "Institution, Location"]
            [:li "Duration - Duration"]]]]]
     (include-css "/css/main.css")))
