angular.module('musicManager.directives', [])
    // http://stackoverflow.com/questions/16207202/required-attribute-not-working-with-file-input-in-angular-js
    .directive('validFile',function(){
        return {
            require: 'ngModel',
            link: function(scope,el,attrs,ngModel) {
                //change event is fired when file is selected
                el.bind('change',function(){
                    scope.$apply(function() {
                        ngModel.$setViewValue(el.val());
                        //ngModel.$render();
                    });
                });
            }
        }
    });