(ns project.core
  (:require [project.rest :as rest]))

(defn -main [& args]
  (rest/run-server)
  (println "Ready!"))
