class HeleController < ApplicationController
  def vstup
    @citac1 = 1

    if session[:citac2]
      @citac2 = session[:citac2]
      @citac2 += 1
      session[:citac2] = @citac2
    else
      @citac2 = 1
      session[:citac2] = @citac2
    end
  end
end
