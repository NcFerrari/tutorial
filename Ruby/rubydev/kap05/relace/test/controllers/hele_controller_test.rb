require "test_helper"

class HeleControllerTest < ActionDispatch::IntegrationTest
  test "should get vstup" do
    get hele_vstup_url
    assert_response :success
  end
end
