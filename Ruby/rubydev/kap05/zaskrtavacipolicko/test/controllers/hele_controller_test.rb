require "test_helper"

class HeleControllerTest < ActionDispatch::IntegrationTest
  test "should get tady" do
    get hele_tady_url
    assert_response :success
  end

  test "should get barva" do
    get hele_barva_url
    assert_response :success
  end
end
