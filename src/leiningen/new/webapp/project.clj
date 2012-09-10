(defproject {{name}} "0.0.1"
  :description "FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.3"]
                 [ring "1.1.5"]
                 [hiccup "1.0.1"]
                 [rmarianski/ring-jetty-servlet-adapter "0.0.3"]
                 [rmarianski/servlet-session-store "0.0.1"]]
  :plugins [[lein-cljsbuild "0.2.7"]]
  :source-paths ["src" "src-cljs"
                 "libraries/clojurescript/src/clj"
                 "libraries/clojurescript/src/cljs"]
  :cljsbuild
  {:builds [{:source-path "src-cljs"
             :compiler {:output-to "resources/public/js/main.js"
                        :optimizations :whitespace
                        :pretty-print true
                        ;; :optimizations :advanced
                        ;; :pretty-print false
                        :libs ["libraries/closure-library/closure"]}}]}
  :ring {:handler {{name}}.routes/app})
