require "test_helper"

class NoTyKokiControllerTest < ActionDispatch::IntegrationTest
  test "should get civava" do
    get no_ty_koki_civava_url
    assert_response :success
  end
end
