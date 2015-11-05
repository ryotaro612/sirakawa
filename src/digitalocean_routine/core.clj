(ns digitalocean-routine.core
  (:gen-class)
  (:require [digitalocean.v2.core :as do]))


(defn droplets-exist? [token]
  "return 0 if droplets exist."
  (not (= (count (:droplets (do/droplets token)))
          0)))

(defn create-droplets [number token image-id ssh_keys]
  (doall (for [name (map #(str "droplet" %) (range 0 (Long/parseLong number)))]
    (do/create-droplet token nil {:name name
                                  :region "nyc3"
                                  :size "1gb"
                                  :image image-id
                                  :ssh_keys [ssh_keys]}))))

(defn query-droplet-ids [token]
  "return droplet ids as a list"
  (let [dropletdetails (do/droplets token)]
    (map #(:id %) (:droplets dropletdetails))))

(def delete-droplet
  "Delete a droplet by ID
  (delete-droplet <token> dropletID) => nil (if it has been deleted successfully)"
  (do/generic :delete :droplets))

(defn delete-all-droplets [token]
  (doall (for [droplet-id (query-droplet-ids token)]
           (delete-droplet token droplet-id))))

(defn -main [& args]
  (cond (= (first args) "create")
         (println (create-droplets (nth args 1) (nth args 2) (nth args 3) (nth args 4)))
         (= (first args) "delete")
         (delete-all-droplets (nth args 1))
         ))


