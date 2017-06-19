(ns code-examples.identity-check
  (:require [clj-http.client :as client]))

(defn run-request []
  (let [url "https://proapi.whitepages.com/3.2/identity_check.json"
        params {:primary.name "Drama Number",
                :primary.phone "6464806649",
                :primary.address.street_line_1 "302 Gorham Ave",
                :primary.address.city "Ashland",
                :primary.address.state_code "MT",
                :primary.address.postal_code "59004",
                :primary.address.country_code "US",
                :secondary.name "Drama Number",
                :secondary.phone "6464806649",
                :secondary.address.street_line_1 "302 Gorham Ave",
                :secondary.address.city "Ashland",
                :secondary.address.state_code "MT",
                :secondary.address.postal_code "59004",
                :secondary.address.country_code "US",
                :email_address "medjalloh1@yahoo.com",
                :ip_address "64.124.61.215",
                :api_key (System/getenv "ID_CHECK_API_KEY")}
        response (client/get url {:query-params params :as :json})
        available-checks [:primary_phone_checks :primary_address_checks
                         :secondary_phone_checks :secondary_address_checks :email_address_checks :ip_address_checks]]

  (select-keys (:body response) available-checks)))
