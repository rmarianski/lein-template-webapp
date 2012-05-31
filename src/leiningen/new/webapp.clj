(ns leiningen.new.webapp
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "webapp"))

(defn webapp
  "cljs webapp how rob likes them"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
             [".gitignore" (render "gitignore" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["script/boostrap" (render "bootstrap" data)]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["src/{{sanitized}}/routes.clj" (render "routes.clj" data)]
             ["src/{{sanitized}}/views.clj" (render "views.clj" data)]
             ["src-cljs/{{sanitized}}/core.cljs" (render "core.cljs" data)]
             )))
