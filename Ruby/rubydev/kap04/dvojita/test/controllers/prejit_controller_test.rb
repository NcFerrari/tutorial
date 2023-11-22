require "test_helper"

class PrejitControllerTest < ActionDispatch::IntegrationTest
  test "should get prace" do
    get prejit_prace_url
    assert_response :success
  end

  test "should get obed" do
    get prejit_obed_url
    assert_response :success
  end
end
