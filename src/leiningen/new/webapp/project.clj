(defproject {{name}} "0.0.1"
  :description "FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.0"]
                 [ring "1.1.0"]
                 [hiccup "1.0.0"]]
  :dev-dependencies [[lein-ring "0.6.7"]]
  :plugins [[lein-cljsbuild "0.1.8"]]
  :source-paths ["src" "src-cljs"
                 "libraries/clojurescript/src/clj"
                 "libraries/clojurescript/src/cljs"
                 "libraries/domina/src/cljs"]
  :cljsbuild
  {:builds [{:source-path "src-cljs"
             :compiler {:output-to "resources/public/js/main.js"
                        :optimizations :whitespace
                        :pretty-print true
                        ;; :optimizations :advanced
                        ;; :pretty-print false
                        :libs ["libraries/closure-library/closure"]}}]}
  :ring {:handler {{name}}.routes/app})
