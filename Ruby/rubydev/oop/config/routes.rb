Rails.application.routes.draw do
  get 'modules/index'
  get 'singleton/index'
  get 'statika_vs_instance/index'
  root 'home#index'
end
