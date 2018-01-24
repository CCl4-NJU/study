/**
 * Created by zfl on 2016/6/7.
 */
'use strict';

/**
 * @ngdoc function
 * @name jqueryApp.controller:AboutCtrl
 * @description
 * # ContactCtrl
 * Controller of the jqueryApp
 */
angular.module('jqueryApp')
  .controller('ContactCtrl', function () {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    $(document).ready(function() {
      $('.tour').on('mouseenter', function() {
        $(this).css({'background-color':'green','font-size':'20px'});
      });
      $('.lead').on('click',function(){
        $('.s').show('slow');   //show()  把一块display：none的显示出来
      });
      $('.tour').on('mouseenter', function () {
        $(this).animate({'margin-top': '40px', 'opacity': '0.5'}, 'slow');//animate
        //opacity 透明度    fast可加可不加
      });
      $('.shape').on('click',function(){
        $(this).css({'width':'600px','transition':'width  2s'});
      //   width:600px;
      //   transition: width  2s;
      //  transition: width 2s;
      //  -moz-transition: width 2s; /* Firefox 4 */
      //  -webkit-transition: width 2s; /* Safari 和 Chrome */
      //  -o-transition: width 2s; /* Opera */
      });
    });
  });
