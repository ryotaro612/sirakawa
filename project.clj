(defproject digitalocean-routine "0.1.0-SNAPSHOT"
  :description "A script to create and delete droplets"
  :url "https://github.com/KazumaSATO/digitalocean-routine"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}

  :main digitalocean-routine.core
  :profiles {:uberjar {:main digitalocean-routine.core :aot :all}}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [digitalocean/digitalocean "1.2"]
                 ])
