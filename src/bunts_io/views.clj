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
          [:p "I am a computer programmer at heart. Over the past 12 years I have worked across many technologies, provided direction and mentorship to teams of developers and developed and deployed well over 250 websites and web-based applications. I've also introduced new technologies into several companies and provided on-site training. I have a deep love for the art and science of computer programming - a love that I express via many of my open-source projects."]
          [:p "I spend most of my time in Rust, Python, Ruby, Typescript, Lua, Clojure (and various other dialects of Lisp). I'm especially interested in the topic of programming languages and the history of the field of computer science."]
          [:p "I believe that humility is a virtue and still find that I learn something new almost every day."]]]
      [:section {:id "experience"}
        [:h2 "Experience"]
        [:div {:class "indent"}
          [:ul
            [:li [:strong "Technical Director"]]
            [:li "Hardhat, Melbourne"]
            [:li "May 2013 - Present"]
            [:li {:class "details"} "As the company grew, there was a need for a manager of the development team. I took on this responsibility and grew the team out to eight people. It was my job to mentor junior developers and instil confidence in them, maintain infrastructure (DevOps) and represent technology at a board-level. This position is generally 85% management, 15% production."]]
          [:ul
            [:li [:strong "Lead Developer"]]
            [:li "Hardhat, Melbourne"]
            [:li "May 2010 - May 2013"]
            [:li {:class "details"} "I came into Hardhat with the task of reinventing their technological capabilities. I built a new team of developers and moved the company across to Ruby on Rails. I also implemented best practises such as version control and automated deployment. In this role I was 80% production %20 management. I worked on many mid-large websites including several corporate websites and also a bunch of heavy-traffic campaign apps."]]
          [:ul
            [:li [:strong "Senior Developer"]]
            [:li "Ansearch, Melbourne"]
            [:li "February 2009 - February 2010"]
            [:li {:class "details"} "In this position I worked in a small team of Perl, Ruby and Python programmers who were working on proprietary search engine software. I spent the majority of my time working in Python on a concurrent advertising aggregator that served online advertising to many thousands of websites. It was a very challenging and rewarding project at the time."]]
          [:ul
            [:li [:strong "Lead Developer"]]
            [:li "Webfirm, Melbourne"]
            [:li "March 2008 - February 2009"]
            [:li {:class "details"} "I was given the chance to move interstate as the company expanded. I looked after the dev team and also worked on small-mid sized web applications. I also used my newfound responsibility to switch the company from ASP classic to Ruby on Rails. I managed a small team of three here."]]
          [:ul
            [:li [:strong "Web Developer"]]
            [:li "Webfirm, Perth"]
            [:li "August 2005 - February 2008"]
            [:li {:class "details"} "I joined the team as a junior web developer. I was primarily working in ASP Classic using some proprietary libraries. We were a team of about six developers and there was no separation between front-end and back-end developers."]]]]
      [:section {:id "education"}
        [:h2 "Education"]
        [:div {:class "indent"}
          [:ul
            [:li [:strong "Advanced Diploma of Software Development (Web)"]]
            [:li "Central Institute of Technology, Perth"]
            [:li "2004 - 2005"]]
          [:ul
            [:li [:strong "Diploma of Software Development"]]
            [:li "Central Institute of Technology, Perth"]
            [:li "2003 - 2004"]]]]]
     (include-css "/css/main.css")))
