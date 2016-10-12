(ns code-examples.identity-check
  (:require [clj-http.client :as client]))

(defn run-request []
  (let [url "https://proapi.whitepages.com/3.1/identity_check.json"
        params {:billing.name "Drama Number",
                :billing.phone "6464806649",
                :billing.address.street_line_1 "302 Gorham Ave",
                :billing.address.city "Ashland",
                :billing.address.state_code "MT",
                :billing.address.postal_code "59004",
                :billing.address.country_code "US",
                :shipping.name "Drama Number",
                :shipping.phone "6464806649",
                :shipping.address.street_line_1 "302 Gorham Ave",
                :shipping.address.city "Ashland",
                :shipping.address.state_code "MT",
                :shipping.address.postal_code "59004",
                :shipping.address.country_code "US",
                :email_address "medjalloh1@yahoo.com",
                :ip_address "64.124.61.215",
                :api_key (System/getenv "ID_CHECK_API_KEY")}
        response (client/get url {:query-params params :as :json})
        available-checks [:billing_name_checks :billing_phone_checks :billing_address_checks :shipping_name_checks
                         :shipping_phone_checks :shipping_address_checks :email_address_checks :ip_address_checks]]

  (select-keys (:body response) available-checks)))
