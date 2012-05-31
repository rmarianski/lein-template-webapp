(ns {{name}}.views
  (:use [hiccup.page :only (xhtml include-js)]
        [hiccup.element :only (javascript-tag)]))

(defn javascript []
  (list (javascript-tag "var CLOSURE_NO_DEPS = true;")
        (include-js "/js/main.js")))

(defn layout [request options body]
  (xhtml
   [:head
    [:meta {:http-equiv "content-type" :content "text/html; charset=utf-8"}]
    [:meta {:charset "utf-8"}]
    [:title (if (string? options) options (:title options))]]
   [:body
    body
    (javascript)
    (when (:js options)
      (javascript-tag (:js options)))]))

(defn index [request]
  (layout
   request
   {:title "Home Page" :js "{{name}}.core.say_hello();"}
   [:h1 "Hello World!"]))

(defn not-found [request]
  (layout request "404 Not Found"
          [:h1 "404 Page Not Found"]))
