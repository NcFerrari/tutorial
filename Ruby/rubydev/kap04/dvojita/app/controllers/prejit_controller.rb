class PrejitController < ApplicationController
  def prace
    if Time.now.hour == 12
      render(:action => :obed)
    else
      render
    end
  end

  def obed
  end
end
