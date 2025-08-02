package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysMember;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.service.ISysMemberService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2025-08-10
 */
@Controller
@RequestMapping("/system/member")
public class SysMemberController extends BaseController
{
    private String prefix = "system/member";

    @Autowired
    private ISysMemberService sysMemberService;

    @RequiresPermissions("system:member:view")
    @GetMapping()
    public String member()
    {
        return prefix + "/member";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:member:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysMember sysMember)
    {
        startPage();
        List<SysMember> list = sysMemberService.selectSysMemberList(sysMember);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:member:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysMember sysMember)
    {
        List<SysMember> list = sysMemberService.selectSysMemberList(sysMember);
        ExcelUtil<SysMember> util = new ExcelUtil<SysMember>(SysMember.class);
        return util.exportExcel(list, "member");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:member:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysMember sysMember)
    {
        return toAjax(sysMemberService.insertSysMember(sysMember));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysMember sysMember = sysMemberService.selectSysMemberById(id);
        mmap.put("sysMember", sysMember);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:member:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysMember sysMember)
    {
        return toAjax(sysMemberService.updateSysMember(sysMember));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:member:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysMemberService.deleteSysMemberByIds(ids));
    }
}
