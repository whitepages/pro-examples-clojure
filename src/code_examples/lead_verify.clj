(ns code-examples.lead-verify
  (:require [clj-http.client :as client]))

(defn run-request []
  (let [url "https://proapi.whitepages.com/3.1/lead_verify.json"
        params {:name "Drama Number",
                :phone "6464806649",
                :email_address "medjalloh1@yahoo.com",
                :address.city "Ashland",
                :address.postal_code "59004",
                :address.state_code "MT",
                :address.street_line_1 "302 Gorham Ave",
                :ip_address "108.194.128.165",
                :api_key (System/getenv "LEAD_VERIFY_API_KEY")}
        response (client/get url {:query-params params :as :json})
        available-checks [:name_checks :phone_checks :address_checks :email_address_checks :ip_address_checks]]

  (select-keys (:body response) available-checks)))
