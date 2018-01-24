'use strict';

/**
 * @ngdoc function
 * @name jqueryApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the jqueryApp
 */
angular.module('jqueryApp')
  .controller('AboutCtrl', function () {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    $(document).ready(function(){
      alert($('img').length);//img的个数
      var t=0;
      $('#tour').on('click','button',function(){
        t++;
        if(t%2!=0) {
          $(this).closest('#tour').find('.photos').slideDown();//先回父本再回来找  //从隐藏到出现，，display：none
          //slidedown 等可以加时间
          $(this).closest('#tour').find('.photos').find('li').find('img').on('mouseenter',function(){
              $(this).closest('#tour').find('.photos').find('li').find('span').slideToggle();
          }
          );
        } else {
          $(this).closest('#tour').find('.photos').slideToggle();//有则删，无则加//toggleClass
        }
      });
      $('#tour').on('mouseenter','p',function(){
        var p=$('<p class="lead">I’m here!</p>');
        $("#tour button").before(p);
      });
      $('#tour').on('mouseleave','p',function(){
        $("#tour .lead").remove();
      });
      $('#nights').on('keyup',function(){
        var day=+$(this).val();// 返回的是数
        //var day=$(this).val();// 返回的是字符串
        $('#nights-count').text(day);
        $('#total').text($(this).closest('.tour').data('daily-price')*$(this).val());
      });
      //$("a").click(function(event){
      //  event.preventDefault();
      //});      防止链接打开
      // preventDefault() 方法阻止元素发生默认的行为（例如，当点击提交按钮时阻止对表单的提交）
      // event.stopPropagation()
      //该方法将停止事件的传播，阻止它被分派到其他 Document 节点。在事件传播的任何阶段都可以调用它。
      // 注意，虽然该方法不能阻止同一个 Document 节点上的其他事件句柄被调用，但是它可以阻止把事件分派到其
      // 他节点。
    });
  });
