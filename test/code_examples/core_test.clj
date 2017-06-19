(ns code-examples.core-test
  (:require [clojure.test :refer :all]
            [code-examples.identity-check :as idc]
            [code-examples.lead-verify :as lv]
            [code-examples.phone-search :as ps]))

(deftest a-test
  (testing "Identity check shall return a coll with 6 items"
    (is (= 6 (count (idc/run-request)))))
  (testing "Lead verify shall return a coll with 4 items"
    (is (= 4 (count (lv/run-request)))))
  (testing "Phone search shall return a coll with 15 items"
    (is (= 15 (count (ps/run-request))))))
