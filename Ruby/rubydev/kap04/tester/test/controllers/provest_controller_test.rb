require "test_helper"

class ProvestControllerTest < ActionDispatch::IntegrationTest
  test "should get pozdrav" do
    get provest_pozdrav_url
    assert_response :success
  end

  test "should get pozdrav2" do
    get provest_pozdrav2_url
    assert_response :success
  end
end
