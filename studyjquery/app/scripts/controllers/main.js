'use strict';

/**
 * @ngdoc function
 * @name jqueryApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the jqueryApp
 */
angular.module('jqueryApp')
  .controller('MainCtrl', function () {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    /*
     * Created by zfl on 2016/6/7.
     */
    // $('h2').text('变换');   //取到所有的h2标签
    // $('span').text('money');

    $('#tours');//取id
    $('.usa');//取class
    $(document).ready(function () {
      $('span').text('money');
    });
    $('#tours li');//取tours里所有的li标签
    $('#tours > li');//所有的chlid的li
    $('#tours').children('li');//所有的chlid的li
    $('.asia,.sale');//选择两个class标签
    $('#vacations .america');//#里的.
    $('#vacations').find('.america');//#里的.
    $('#tours li:first');//第一个li标签
    $('#tours li:last');//最后一个li标签
    $('#tours li:odd');//单数
    $('#tours li:even');//双数
    $('#tours').find('li');//找到所有的li   速度快
    $('#tours').find('li').first();//找到第一个li
    $('li').first();//第一个
    $('li').last();//最后一个
    $('li').first().next();//第一个的下一个
    $('li').first().next().prev();//第一个的下一个的上一个
    $('li').first().parent();//第一个的父元素
    var before = $('<p>这是新创建的before节点。</p>');//创建一个新节点
    $('#tours').before(before);//在#tours之前加入price
    var after = $('<p>这是新创建的after节点</p>');
    $('#tours').after(after);//在#tours之后加入price
    var prepend = $('<p>这是新创建的prepend节点</p>');
    $('#tours').prepend(prepend);//在#tours之中加入price作为第一个子元素
    var append = $('<p>这是新创建的append节点</p>');
    $('#tours').append(append);//在#tours之中加入price作为最后一个元素
    $('.remove').remove();//删除一个节点
    $('button').on('click', function () {
      $(this).closest('.tour').append('closest加入');//找到最近的父元素
      var tour = $(this).closest('.tour');
      var discount = tour.data('discount');//取数据   前提是存在data-discount
      var message = $('<span>Call 1-555-jquery-air for a $' + discount + 'discount.</span>');
      tour.append(message);
      $(this).remove();  //只移除点击的按钮    只在这个下改变
    });//onclick事件   可以是任意模块的点击
    $('.tour').on('click','button', function () {
    });
      //这只选中'.tour'下的button button可以换成class
    $('#tours').filter('.tour');//遍历#tours下的.tour
    $('button').addClass('btn-success btn');//加class   移除是removeClass  hasClass('')判断有无 返回true flase

  });

