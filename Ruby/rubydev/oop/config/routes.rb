Rails.application.routes.draw do
  get 'statika_vs_instance/index'
  root 'home#index'
end
