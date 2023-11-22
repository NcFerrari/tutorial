class PrejitController < ApplicationController
  def prace
    if Time.now.hour == 12
      render(:action => :obed)
    else
      render
    end
  end

  def obed
    render(:file => 'C:\Users\lpesek\Documents\Projekty\tutorial\Ruby\rubydev\kap04\dvojita\app\views\prejit\obed.html.erb')
  end
end
