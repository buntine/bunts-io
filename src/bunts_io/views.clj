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
          [:div [:a {:href "mailto:info@bunts.io"} "info@bunts.io"]]
          [:div "0423 638 309"]
          [:div [:a {:href "http://bunts.io/"} "http://bunts.io/"]]]]
      [:section {:id "summary"}
        [:h2 "Summary"]
        [:div {:class "indent"}
          [:p "I am a computer programmer at heart. Over the past 12 years I have worked across many technologies, provided direction and mentorship to teams of developers and developed and deployed well over 250 websites and web-based applications. I've also introduced new technologies into several companies and provided on-site training. I have a deep love for the art and science of computer programming."]
          [:p "I spend most of my time in Rust, Python, Ruby, Typescript, Lua, Clojure (and various other dialects of Lisp). I'm especially interested in the topic of programming languages and the history of the field of computer science."]]]
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
